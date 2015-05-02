
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<title>Show book list</title>
</head>
<body>

<table border="1">
	<tbody>
		<%-- set the header --%>
		<tr>
			<td>Author</td>
			<td>Book name</td>
			<td>Available</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<%-- check if book exists and display message or iterate over books  --%>
		<logic:empty name="bookListForm" property="books">
			<tr>
				<td colspan="5">No books available</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="bookListForm" property="books">
			<logic:iterate name="bookListForm" property="books" id="book">
				<tr>
					<td><bean:write name="book" property="author" /></td>
					<td><bean:write name="book" property="title" /></td>	

				</tr>
			</logic:iterate>
		</logic:notEmpty>

		<%-- print out the add link --%>
		<tr>
			<td colspan="5"><html:link action="bookEdit.do?do=addBook">Add a new book</html:link>
			</td>
		</tr>


		<%-- end interate --%>



	</tbody>
</table>
</body>
</html>
