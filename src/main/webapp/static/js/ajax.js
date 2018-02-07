function ajax(url,type,data){
	var result=null;
	$.ajax({
	    url:url,
	    type:type, //GET
	   // async:true,    //或false,是否异步
	    data:data ,
	    async: false,
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	   contentType : 'application/json;charset=UTF-8', //contentType很重要   
	    beforeSend:function(xhr){
	      //  console.log('发送前')
	    },
	    success:function(data,textStatus,jqXHR){
	        result=data;
	    },
	    error:function(xhr,textStatus){
	        console.log('错误')
	        console.log(xhr)
	        console.log(textStatus);
	        result=xhr;
	    },
	    complete:function(){
	        //console.log('结束')
	    }
	})
	 return result;
	
}