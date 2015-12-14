var page=1;
var totalPage=0;

$(document).ready(function(){
    $("#submit1").on("click",function(){
        var fcode = $("#fcode").val();
        if(""==fcode.trim()){
            alert("please input")
            return;
        }
        var param = {
            stock:fcode,
            //"K70",
            date:""
            //"2015-9-14 00:00:00"
        };
        AjaxJson("../../handler/stock/sEmotionRs",param,function(data){
            var rs = data.data.result.effective;
            $("#result").html("模型匹配率:"+rs)
//            var dat = data.data.result;
//            for(var i=-5;i<=5;i++){
//                showres(dat,i);
//            }
        });
    });

    $("#submit2").on("click",function(){

        AjaxJson("../../handler/stock/sEmotionRsAll",{},function(data){
            var rs = data.data.result.res;
            $("#result2").html("模型匹配率:"+rs)
//            var dat = data.data.result;
//            for(var i=-5;i<=5;i++){
//                showres(dat,i);
//            }
        });
    });
//	$(".search-picker").change(function(){
//		$(this).next().next().attr("placeholder",$(this).attr("name").split('@')[parseInt($(this).val())-1]);
//	});
//
//    showTable();
//    getListFirst();
//    $("#addButton").click(function(){
//        add();
//        $('#myModal').modal('hide');
//        location.reload();
//    });
});

//table names
//function showTable(){
//    var info=["规则名称","类型","标签","属性","操作"];
//    customTabe(".table-holder",info);
//}
//
//function getListFirst(){
//    getlist();
//    //加载分页
//    paginationDefault(0,1,totalPage,dataCallback);
//}
//
//function getlist(){
//    var requestData={
//        startRow:(page-1)*STATICS().DEFAULT_SIZE,
//        pageSize:STATICS().DEFAULT_SIZE
//    };
//    AjaxJson("../../handler/rule/list",requestData,function(data){
//        if(data.suc==false){
//            alert("error:"+data.msg)
//            return ;
//        }
//        var tableContent="";
//        var da = data.data.result;
//        for(var i=0;i<da.length;i++){
//            tableContent+="<tr>";
//            tableContent+="<td>"+ruf(da[i].name)+"</td>";
//            tableContent+="<td>普通</td>";
//            tableContent+="<td>"+ruf(da[i].label)+"</td>";
//            tableContent+="<td>"+ruf(da[i].attr)+"</td>";
//            tableContent+="<td><input id="+da[i].id+" type=\"button\" class=\"btn btn-danger btn-xs deleteInfo\" value=\"delete\"></td>";
//            tableContent+="</tr>";
//        }
//        $(".myTable").html(tableContent);
//        var count = data.data.count;
//        totalPage=count%STATICS().DEFAULT_SIZE==0?parseInt(count/STATICS().DEFAULT_SIZE):(parseInt(count/STATICS().DEFAULT_SIZE)+1);
//        $(".deleteInfo").click(function(){
//            deleteRule($(this).attr("id"))
//        });
//    });
//}
//
//function add(){
//
//    var data = {
//        name:Get("#name"),
//        label:Get("#label"),
//        attr:Get("#attr")
//    }
//    AjaxJson("../../handler/rule/add",data,function(data){
//        alert(data.suc)
//    });
//}
//
//function dataCallback(pageq,showSizeSide){
//    page=pageq;
//    getlist();
//}
//
//function deleteRule(ruleId){
//    AjaxJson("../../handler/rule/delete",{ruleId:ruleId},function(data){
//        alert(data.suc);
//        location.reload();
//    });
//}
