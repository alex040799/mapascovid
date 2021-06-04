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
			$('#poblacionEdit').val(localidad.poblacion);
			$('#latitudEdit').val(localidad.latitud);
			$('#longitudEdit').val(localidad.longitud);
			$('#provinciaEdit').val(localidad.provincia);
			
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