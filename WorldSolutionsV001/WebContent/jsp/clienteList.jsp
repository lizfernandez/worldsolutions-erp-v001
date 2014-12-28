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
		<logic:empty name="clienteListForm" property="clientes">
			<tr>
				<td colspan="5">No books available</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="clienteListForm" property="clientes">
			<logic:iterate name="clienteListForm" property="clientes" id="book">
				<tr>
					<%-- print out the book informations --%>
					<td><bean:write name="book" property="codUsuario" /></td>
					<td><bean:write name="book" property="apematCliente" /></td>					
					</td>

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
