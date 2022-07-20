/**
 *  usado em DEPARTAMENETO.HTML E FUNCINARIO.HTML
 */
 
 //DEPARTAMENTO
 $(document).ready(function(){
	$(".table .btnEdicao").on('click', function(event){
		event.preventDefault();
		//pegou o href que está no botão editar e colocou no get. O x é o retorno do nosso objeto java em JSON
		var href = $(this).attr('href');
		$.get(href, function(x, status){
			$("#editId").val(x.id);
			$("#editNome").val(x.nome);
		})
		$("#editDepartamento").modal();
	})
	
	
	$('.table  .deletebtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$("#deleteModal #deleteId").attr('href',href);  
		$("#deleteModal").modal();
	})
	
	  
//FUNCIONARIO
	
	$(".table .btnEdicaoFunc").on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(func, status){
			$("#feditId").val(func.id);
			$("#feditNome").val(func.nome);
			$("#feditDocumento").val(func.documento);
			var dateGet = func.nascimento.split('-');
			//var nascimento = dateGet[2] + '/' + dateGet[1] + '/' + dateGet[0];
			$("#feditNascimento").val(func.nascimento);
		    $("#feditSalario").val(func.salario);
		    $("#fteste").val(func.reldepartamento.nome);
		  	$("#feditDepartamento").val(func.reldepartamento.id);
		  	 
		})
		
		$("#editFuncionario").modal();
	})
	
	//ao adicionar um novo funcionário
	$(".btnAdd").on('click', function(event){
		event.preventDefault();
		var soma = 0;
		$('.obrigatorio').each(function() {
	      if ($(this).val() == '') {
		    soma = soma +1;
	        jAlert('O campo  ' + $(this).attr('name')   + '   é obrigatório');
	        return false;
	      }
		})
		
		if(soma == 0){
			var dateGet = $("#addnascimento").val().split('/');
			var nascimento = dateGet[2] + '-' + dateGet[1] + '-' + dateGet[0];
			$("#addnascimento").val(nascimento);
			$("#formCadastrar").submit();
		}
	})
	
	//ao editar um novo funcionário
	$(".btnEditarCadastro").on('click', function(event){
		event.preventDefault();
		var soma = 0;
		$('#formEditar .obrigatorioe').each(function() {
	      if ($(this).val() == '') {
		    soma = soma +1;
	        jAlert('O campo  ' + $(this).attr('name')   + '   é obrigatório');
	        return false;
	      }
		})
		
		if(soma == 0){
			$("#formEditar").submit();
		}
	})
	
})

