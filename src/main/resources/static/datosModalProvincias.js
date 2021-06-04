/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(provincia, status){
			
			$('#nombreEdit').val(provincia.nombre);
			$('#latitudEdit').val(provincia.latitud);
			$('#longitudEdit').val(provincia.longitud);
			
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