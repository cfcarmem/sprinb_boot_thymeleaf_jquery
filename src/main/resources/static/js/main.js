 
/*  NÃO ESTAMOS USANDO
$(document).ready(function(){
	$(".table .btnEdicao").on("click", function(event){
		event.preventDefault();
		var href = $(this).attr("href");
		$.get(href, function(departamentos, status){
			console.log(departamentos.id)
			$("#editId").val(departamentos.id);
			$("#editNome").val(departamentos.nome);
		})
		
		$("#editDepartamento").modal();
	})
	
})

*/