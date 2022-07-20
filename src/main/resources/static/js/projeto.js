

//quando é um novo registro
function carregarGestores(valor,valorst){
	$.ajax({
		method:'GET',
		url:"/pessoas",
		 dataType: 'json',
	})
	.done(function(obj){
		 var selectbox = $('#pngestor');
         selectbox.find('option').remove();
		 if (obj != null) {
             var data = obj.data;
             $('<option>').val('').text("----informe o gestor-----").appendTo(selectbox);
            for(var i=0; i< obj.length;i++){
            	 $('<option>').val(obj[i].id).text(obj[i].nome).appendTo(selectbox);
            }
            if(valor != 0){
				$('#pngestor').val(valor).change();
			}
         }	
		 carregarStatus(valorst);
	})
	.fail(function(err){
		jAlert("Ocorreu um erro inesperado. Entre em contato com o administrador do sistema.")
	})

 }
 
 //quando for novo registro
function carregarStatus(valor){
	$(() => {
		 var selectbox = $('#pnstatusprojeto');
		  const request = $.ajax({
			  url:"/status/",
		   // url: "https://jsonplaceholder.typicode.com/users",
		    method: "get",
		    dataType: "json"
		  });
		  request.done(obj => {
			$("#pnstatusprojeto option").remove();
		    $(obj).each(i => {
			 console.log(obj[i])
		    	 $('<option>').val(obj[i]).text(obj[i]).appendTo(selectbox);
		    });
		    if(valor != 0){
			   $("#pnstatusprojeto").val(valor).change();
		    }
		  });
		  

		});

}
 
	$(".btnSalvarNovo").on('click', function(event){
		event.preventDefault();
		var forms = $("#formAdicionar").serializeArray();
		var soma = 0;
		$('#formAdicionar .obrigatorioe').each(function() {
	      if ($(this).val() == '') {
		    soma = soma +1;
	        jAlert('O campo  ' + $(this).attr('name')   + '   é obrigatório');
	        return false;
	      }
		})
		
		var formData = {
			id: $("#pnid").val(),
			nome: $("#pnome").val(),
			inicio: $("#pninicio").val(),
		    fim: $("#pnfim").val(),
		    flag_gestor: $("#flag_gestor").val(),
		   // gestor: $("#pngestor").val(),
		   gestor:
			{"id":$("#pngestor").val()},
		    statusprojeto: $("#pnstatusprojeto").val()
		   
		}
		
		var metodo = "PUT";
		if($("#pnid").val().length == 0){
			metodo = "POST";
		}
		//console.log(JSON.stringify(formData));
		if(soma == 0){
			$.ajax({
				url:"/projetos",
				data:JSON.stringify(formData),
				method: metodo,
				dataType: "json",
				contentType:"application/json; charset=utf-8"
			})
			.done(function(){
				$("#alertas").html("Projeto adicionado com sucesso.");
				$("#alertas").show();
				$(() => {setTimeout(function(){
						$("#alertas").empty();
						$("#alertas").hide();
					},1000)
				})
				
				$('#formAdicionar').each (function(){
				  this.reset();
				});
		
			})
		}
		//pegou o href que está no botão editar e colocou no get. O x é o retorno do nosso objeto java em JSON
	})
	
	
	//editar projeto, carrega os campos para edição	
	function editarRegistro(id){
		var formData = {
				id: id
		}
		$.ajax({
			// url: "/cadastroprojetos/buscarId/"+vid,
			 url:"/projetos/"+id,
			 method: "GET",
			// data:{"id":id},
			//data: JSON.stringify(formData),
			dataType:"json",
		})
		.done(function(retorno){
			$("#pnstatusprojeto option").remove();
			$("#pnid").val(retorno.id);
			$("#pnome").val(retorno.nome);
			$("#pninicio").val(retorno.inicio);
			$("#pnfim").val(retorno.fim);
			$("#flag_gestor").val(retorno.flag_gestor);
			carregarGestores(retorno.gestor.id,retorno.statusprojeto);
			$("#novoProjeto").modal();  
		})
	}

	
	
	
//EQUIPE
var contador =0;
function abrir_equipe(id){
	$("#idprojetoLocal").val(id)
	  $.ajax({
		  url:'/projetoequipe',
		  method:'GET',
	  })
	  //equipe.html
	  .done(function(retorno){
		   $("#dialog-equipe" ).dialog( "option", "title", "Equipe do Projeto "+id);
		   $("#dialog-equipe" ).html(retorno);
		   $("#idprojeto").val(id)
		   $("#dialog-equipe" ).dialog("open");
		   //carregar select pequipe
		   carregarFuncEquipe();
	  })
}



//quando é um novo registro, carrega o combo com os funcionarios
function carregarFuncEquipe(valor){
	$.ajax({
		method:'GET',
		url:"/equipe",
		dataType: 'json',
	})
	.done(function(obj){
		 var selectbox = $('#pequipe');
         selectbox.find('option').remove();
		 if (obj != null) {
             var data = obj.data;
             $('<option>').val('').text("----informe o gestor-----").appendTo(selectbox);
            for(var i=0; i< obj.length;i++){
            	 $('<option>').val(obj[i].id).text(obj[i].nome).appendTo(selectbox);
            }
            if(valor != 0){
				$('#pequipe').val(valor).change();
			}
         }	
	})
	.fail(function(err){
		jAlert("Ocorreu um erro inesperado. Entre em contato com o administrador do sistema.")
	})

 }


//essa function é chamada a partir do equipe.html
function mostrarListagem(){
	contador = contador + 1;
	var id2 = $("#idprojetoLocal").val();
	//contador = contador+1;
	//alert("contador" +contador)
	$.ajax({
		url:'/projetoequipelistar',
		method:'Post',
	})
	.done(function(retorno){
		$("#listagem_equipe").html(retorno);
		$("#idprojetoEquipe").val(id2);
		carregarListagemEquipe();
	})
	
}

function adicionarUsuEquipe(){
	var idprojeto = $("#idprojeto").val();
    var selectbox =$( "#pequipe option:selected" ).val()
    if(selectbox.length == 0){
    	jAlert("Informe o funcionário.")
    	return false;
    }
    var formData = {
    		id: idprojeto
    	//	idfuncionario:selectbox
    }
    
    //alert(JSON.stringify(formData))
    $.ajax({
		url:'/equipe/'+selectbox+'/'+idprojeto,
		//NO POST NÃO PRECISA PASSAR PARAMETRO NA URL, SOMENTE NO BODY
		method:'POST',
		//data:JSON.stringify(formData),
		dataType:'Json'
	})
    
    //vamos adicionar o funcionario acessando o controller 
  	mostrarListagem();
}

function apagarUsuarioEquipe(idfuncionario, idprojeto){
	jConfirm('Deseja desalocar o funcionário da equipe?', 'Confirmação', function(r) {
		if(r == true){
			//jAlert('Confirmed: ' + r, 'Confirmation Results');
			$.ajax({
				url:"/equipe/"+idfuncionario+'/'+idprojeto,
				method:"Delete"
			})
			.done(function(resultado){
				//recarregar a lista
				mostrarListagem();
			})
		}
    	
	});
	
}
