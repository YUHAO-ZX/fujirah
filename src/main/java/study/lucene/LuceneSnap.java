package study.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by yuhao.zx on 15-10-23.
 */
public class LuceneSnap{
    public static void main(String[] args) {
        IndexWriter writer = null;
        try {
            // Directory directory = new RAMDirectory();内存
            Directory directory = FSDirectory.open(Paths.get("d:/itxxz/lucene"));
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(directory,iwc);
            Document document = null;
            File f = new File("d:/itxxz/data");
            for (File file : f.listFiles()) {
                System.out.println("as:" + file.getName());
                System.out.println("test git");
                document = new Document();
                document.add(new LongField("modified", f.lastModified(),
                        Field.Store.NO));
                document.add(new TextField("contents", new FileReader(file)));
                document.add(new StringField("as", file.toString(),
                        Field.Store.YES));
                writer.addDocument(document);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
