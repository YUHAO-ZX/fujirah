$(document).ready(function(){
	$(".pay_left").html(
			"<ul><li><a href='./feeDetail.html'>费用详情查询</a></li>"+
				"<li><a href='./feeDetailItem.html'>类目收费列表</a></li>"+
			"</ul>");
	$(".search-picker").change(function(){
		$(this).next().next().attr("placeholder",$(this).attr("name").split('@')[parseInt($(this).val())-1]);
	});
//	pagination(1,1,100,STATICS().SHOW_SIZE,true);

    $("#submit1").on("click",function(){
        var fcode = $("#fcode").val();
        var time = $("#time").val();
        if(""==fcode.trim()){
            alert("please input")
            return;
        }
        var param = {
            stock:fcode,
            //"K70",
            date:time
            //"2015-9-14 00:00:00"
        };
        AjaxJson("../../handler/stock/sEmotion",param,function(data){

//            var dat = data.data.result;
//            for(var i=-5;i<=5;i++){
//                showres(dat,i);
//            }
        });
    });

});