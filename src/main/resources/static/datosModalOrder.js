/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(localidad, status){
			
			$('#idEdit').val(localidad.id);
			$('#nombreEdit').val(localidad.nombre);
			$('#requiredDateEdit').val(order.requiredDate);
			$('#shippedDateEdit').val(order.shippedDate);
			$('#statusEdit').val(order.status);
			$('#customernumberEdit').val(order.customernumber);
			
		});
		
		$('#editModal').modal();
		
	});
	
	
	$('.table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});