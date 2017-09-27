<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js">
	</script>
</head>
<body>
<h2 align="center">Invoice Details</h2>
<c:if test="${!empty invoiceList}">
	<table id="invTable" class="display" cellspacing="0" width="100%">
	<thead>
	<tr align="left">
		<th width="80" align="left">Invoice Id</th>
		<th width="120" align="left">Firstname</th>
		<th width="120" align="left">mobile</th>
	</tr>
	<thead>
	<tfoot>
	<tr>
		<th width="80" align="left">Invoice Id</th>
		<th width="120" align="left">Firstname</th>
		<th width="120" align="left">mobile</th>
	</tr>
     </tfoot>
	<c:forEach items="${invoiceList}" var="invoiceBean">
		<tr>
			<td>${invoiceBean.invoice.id}</td>
			<td>${invoiceBean.customerDetail.firstname}</td>
			<td>${invoiceBean.customerDetail.mobile}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<script>
    	$(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#invTable tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );
 
    // DataTable
    var table = $('#invTable').DataTable();
 
    // Apply the search
    table.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
} );
    </script>
    <style>
    tfoot input {
        width: 30%;
        padding: 3px;
        box-sizing: border-box;
        align:left;
    }
    a {
    padding:3px;
    }
    </style>
</body>
</html>
