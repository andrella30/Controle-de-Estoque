/**
 * 
 */
function validar_movimentacao() {


	let quantidade = frmMovimentacao.quantidade.value
	
	
	if (quantidade === "") {
		alert('Preencha o campo Quantidade')
		frmMovimentacao.quantidade.focus()
		return false
	} else {
		document.forms["frmMovimentacao"].submit()
	}

}