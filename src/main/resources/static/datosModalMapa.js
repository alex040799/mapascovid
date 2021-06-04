/**
 * 
 */
 
 $('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(mapa, status){
			
			$('#idEdit').val(mapa.id);
			$('#nombreEdit').val(mapa.nombre);
			$('#tipoEdit').val(mapa.tipo);		
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