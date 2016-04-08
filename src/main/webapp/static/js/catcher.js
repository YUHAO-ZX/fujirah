$(document).ready(function(){

    $("#submit").on("click",function(){
        var fcode = $("#fcode").val();
        var time = $("#time").val();
        if(""==fcode.trim() || time.trim()==""){
            alert("please input")
            return;
        }
        var param = {
            fcode:fcode,
            //"K70",
            date:time+" 00:00:00"
            //"2015-9-14 00:00:00"
        };
        AjaxJson("../../handler/stock/stocks",param,function(data){
            var dat = data.data.result;
            for(var i=-5;i<=5;i++){
                showres(dat,i);
            }
        });
    });
});
function showres(dat,i){
    var cool = 0;
    for(var j = 0;j < dat.COOL.length;j++){
        if(dat.COOL[j].split("&")[0]==i){
            cool =  dat.COOL[j].split("&")[1]
        }
    }
    var smile = 0;
    for(var j = 0;j < dat.SMILE.length;j++){
        if(dat.SMILE[j].split("&")[0]==i){
            smile =  dat.SMILE[j].split("&")[1]
        }
    }
    var cry = 0;
    for(var j = 0;j < dat.CRY.length;j++){
        if(dat.CRY[j].split("&")[0]==i){
            cry =  dat.CRY[j].split("&")[1]
        }
    }

    var t = '#container'+(i+6);
    var title = "消息发布"
    if(i < 0){
        title+="前"+(-i)+"天"
    }else if(i == 0){
        title+="当天"
    }else{
        title+="后"+(i)+"天"
    }
    if(cry==0&&smile==0&&cool==0){
        title = "星期六或星期天无交易";
    }
    $(t).highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: title
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        chart:{height:300, width:300},
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['涨:'+smile,   parseInt(smile)],
                ['跌:'+cry,   parseInt(cry)],
                ['持平:'+cool,    parseInt(cool)]
            ]
        }]
    });
}