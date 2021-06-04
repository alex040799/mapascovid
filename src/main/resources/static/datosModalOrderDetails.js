/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(orderDetail, status){
			
			$('#idEdit').val(orderDetail.id);
			$('#productCodeEdit').val(orderDetail.productCode);
			$('#quantityOrderedEdit').val(orderDetail.quantityOrdered);
			$('#priceEachEdit').val(orderDetail.priceEach);
			$('#orderLineNumberEdit').val(orderDetail.orderLineNumber);
			
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