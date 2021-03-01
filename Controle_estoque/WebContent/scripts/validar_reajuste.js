/**
 * 
 */
function validar_reajuste() {


	let preco = frmReajuste.preco.value

	if (preco === "") {
		alert('Preencha o campo Quantidade')
		frmReajuste.quantidade.focus()
		return false
	} else {
		document.forms["frmReajuste"].submit()
	}

}