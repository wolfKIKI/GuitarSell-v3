<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>guitarlist</title>
<style type="text/css">
*{
    margin: 0;padding: 0;
}
#wrap{
    width: 900px;margin: 0 auto;
}
#header{
    width: 100%;background: #cfc;height: 50px;
    text-align: center;font-size: 40px
}
#mainbody{
    margin-top:20px;
    
}
#img1{
    width: 100px;height:80px;
   float:left;
   margin-left: 40px;margin-right:60px;
}
.text1{
    height: 30px;width:100px;border-color: #55f;
    font-size:20px;float: left;margin-top:20px;margin-right:10px;margin-top:30px;
}
.img1{
    width:160px;height:200px;
}
h1{
	color:#36F;
	margin-top;
}
.center{
	margin-top:70px;
}
.btn{

   
  height:30px;
  width:70px;
  color:#ffffff;
  background-color:#3ba354;
  font-size:20px;
  font-weight:normal;
  font-family:Arial;
  border:0px solid #dcdcdc;
  -webkit-border-top-left-radius:3px;
  -moz-border-radius-topleft:3px;
  border-top-left-radius:3px;
  -webkit-border-top-right-radius:3px;
  -moz-border-radius-topright:3px;
  border-top-right-radius:3px;margin-left: 0;margin-top:30px;
}
table{
	border:2px solid #999;width:100%;
}
.bottom{
    margin-top:20px;
}
</style>
</head>
<body>
	<form action="search.jsp" method="post">
    <div id="wrap">
        <div id="header">Rick's Guitar
        </div>
        <div id="mainbody">
            <div class="top">
                <img id="img1" src=".\img\2.jpg" alt="guitar图标" />
                <h1>welcome to Rick's GuitarCenter</h1></div>
                <div class="center">
            	<div><label >请选择弦数：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="six">6</label><input type="radio" id="six" value="6" name="numstrings" />&nbsp;&nbsp;<label for="twlve">12</label><input type="radio" id="twlve" value="12" name="numstrings" />
              </div>
              <br />
               <div> <label >请选择制造商：</label>&nbsp;&nbsp;&nbsp;&nbsp;<select class="select" name="builder"><option value="FENDER">FENDER</option><option value="MARTIN">MARTIN</option><option value="GIBSON">GIBSON</option><option value="COLLINGS">COLLINGS</option><option value="OLSON">OLSON</option><option value="RYAN">RYAN</option><option value="PRS">PRS</option><option value="ANY">ANY</option></select></div>
               <br />
               <div> <label >请输入型号：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="model" type="text" /></div><br />
               <div> <label >请选择类型：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="acoustic">ACOUSTIC</label><input type="radio" id="" value="ACOUSTIC" name="type" />&nbsp;&nbsp;<label for="electric">ELECTRIC</label><input type="radio" id="electric" value="ELECTRIC" name="type" /></div>
               <br />
               <div> <label >请选择前面材料：</label><select class="select" name="topWood"><option value="INDIAN_ROSEWOOD">INDIAN_ROSEWOOD</option><option value="BRAZILIAN_ROSEWOOD">BRAZILIAN_ROSEWOOD</option><option value="MAHOGANY">MAHOGANY</option><option value="MAPLE">MAPLE</option><option value="COCOBOLO">COCOBOLO</option><option value="CEDAR">CEDAR</option><option value="ADIRONDACK">ADIRONDACK</option><option value="ALDER">ALDER</option><option value="SITKA">SITKA</option></select></div>
                <br />
                <label >请选择背面材料：</label><select class="select" name="backWood"><option value="INDIAN_ROSEWOOD">INDIAN_ROSEWOOD</option><option value="BRAZILIAN_ROSEWOOD">BRAZILIAN_ROSEWOOD</option><option value="MAHOGANY">MAHOGANY</option><option value="MAPLE">MAPLE</option><option value="COCOBOLO">COCOBOLO</option><option value="CEDAR">CEDAR</option><option value="ADIRONDACK">ADIRONDACK</option><option value="ALDER">ALDER</option><option value="SITKA">SITKA</option></select>
            </div>
                <input class="btn"type="submit" name="搜索"value="查询"/>
                 
            </div>
            <div class="bottom">
            	<table>
                <thead><td>序号</td><td>价格</td>弦数</td><td><td>制造商</td><td>型号</td><td>类型</td><td>前面材料</td><td>背面材料</td><td>操作</td></thead>
               <c:forEach items="${list}" var="g">
	<tr>
	<td>${g.serialNumber}</td>
	<td>${g.getSpec().getBuilder()}</td>
	<td>${g.getSpec().getModel()}</td>	
	<td>${g.getSpec().getType()}</td>
	<td>${g.getSpec().getBackWood()}</td>
    <td>${g.getSpec().getTopWood()}</td>
	<td>${g.price}</td>	
	<td><a href="delete?serialNumber=${g.serialNumber}">删除</a>
	</tr>

</c:forEach>
                </table>
            </div>
        </div>
        <div id="footer"></div>
    </div>
    </form>
</body>
</html>