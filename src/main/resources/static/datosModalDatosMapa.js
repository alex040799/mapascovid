/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(datosmapatabla, status){
			
			$('#idEdit').val(datosmapatabla.id);
			$('#localidadEdit').val(datosmapatabla.localidad);
			$('#casosEdit').val(datosmapatabla.casos);
			$('#mapaEdit').val(datosmapatabla.mapa);
			
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