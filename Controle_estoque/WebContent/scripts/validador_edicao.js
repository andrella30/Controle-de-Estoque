/**
 * 
 */
function validar() {
	let preco = frmEdicao.preco.value
	let quantidade = frmEdicao.quantidade.value
	let unidade = frmEdicao.unidade.value

	if (preco === "") {
		alert('Preencha o campo Preco')
		frmProduto.preco.focus()
		return false
	} else if (preco < 0) {
		alert('Valor Invalido')
		frmProduto.preco.focus()
		return false
	} 
	else if (quantidade === "" || quantidade < 0) {
		alert('Preencha o campo Quantidade')
		frmProduto.quantidade.focus()
		return false
	}  else if (unidade === "") {
		alert('Preencha o campo Unidade')
		frmProduto.unidade.focus()
		return false
	} else {
		document.forms["frmEdicao"].submit()
	}
}