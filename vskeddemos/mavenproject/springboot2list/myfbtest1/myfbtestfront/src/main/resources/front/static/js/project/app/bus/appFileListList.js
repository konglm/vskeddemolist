'use strict'

$(function(){
	$('#queryBt').on('click',appFileListList.query);
	appFileListList.initUI();
	appFileListList.list();
});

var appFileListList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appfilelistlist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.phone=$('#phone').val();
                	d.username=$('#username').val();
                	d.type=$('#type').val();
                },
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
			select:'single',//可选值os,single,multi 当值为os时可以按住ctrl或shift可以多选
			columnDefs: [{targets: [0],	visible: false,	searchable: false },
				{targets: [1],	visible: false,	searchable: false }
			],
		    searching: false, //隐藏搜索
		    processing: true,  //隐藏加载提示,自行处理
		    serverSide: true,  //启用服务器端分页
		    orderMulti: false,  //启用多列排序
		    order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
		    ordering:false,//关闭排序
		    paging: true,//开启分页
		    pageLength: webCommon.dataTablePageLength,//每页显示10条
		    lengthMenu:webCommon.dataTableLengthMenu,//每页显示多少条列表
		    pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
		    fnRowCallback:function(nRow,aData,iDataIndex){
		    	return nRow;
		    },
		    dom:'<"html5buttons"B>lTfgitp',
		    buttons:[
		        {
		            text:'上传',
		  	        action:function(e, dt, node, config){
		  	        	appFileListList.toAdd();
		  	        }
		  	    },
		        {
		            text:'删除',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		swal({
		  	        			title: "你确定？",
		                        text: "你将无法恢复这些被选中的记录！",
		                        type: "warning",
		                        showCancelButton: true,
		                        confirmButtonColor: "#DD6B55",
		                        confirmButtonText: "删除",
		                        cancelButtonText: "取消",
		                        closeOnConfirm: false,
		                        closeOnCancel: true 
		                        },function (isConfirm) {
		                        	if (isConfirm) {
		    		  	        		var fid=selectData[0].id;
		    		  	        		var fid1=selectData[0].path;
		    		  	        		
		    		  	        		var myBasePath='/webapi/v1/appfilelistdel';
		    		  	        		$.post(myBasePath,{token:$('#servertoken').val(),fid:fid,fid1:fid1},function (dt){
		    		  	        			if('000000'==dt.code){
		    		  	        				swal("删除", "选中数据已被删除.", "success");
		    		  	        				appFileListList.query();
				    		  	  			}else{
				    		  	  			    swal("取消", "选中数据删除失败:"+dt.msg, "error");
				    		  	  			}
				    		  	  			    
				    		  	  	    },'json');
		    		  	      			
		                            }
		                    });

		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'path'},
		  	    {data:'type',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='图片';
					 }else if('2'==data){
					     rs='视频';
					 }else if('3'==data){
						 rs='聊天';
					 }else if('4'==data){
						 rs="头像";
					 }else if('5'==data){
						 rs="广告";
					 }else if('6'==data){
						 rs="影片";
					 }else if('7'==data){
						 rs="影星";
					 }else if('8'==data){
						 rs="apk";
					 }else if('9'==data){
						 rs="banner";
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	    {data:'sourcetype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='app用户';
					 }else if('2'==data){
					     rs='web后台';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
			  	{data:'phone'},
			  	{data:'username'},
			  	{data:'filesize'},
			  	{data:'name'},
		  	    {data:'fileurl',
			  	   	 render:function(data, type, full, meta){
			  	   	 return '<img src="'+data+'" width=150 height=150 />';
			  	}},
		  	    {data:'addtime',
			  	   	 render:function(data, type, full, meta){
			  	   	 return webCommon.dtfmt3(data);
			  	}}
		  	  	]
		 });
		
	},
	query:function(){
		$('#dt0').DataTable().ajax.reload();
	},	
    toAdd:function(){
    	webCommon.loadPage('/webapi/v1/toappfilelistadd',{token: $('#servertoken').val() });
	},
	initUI:function(){
		$('#type').select2({width: '100%'});
	}
});