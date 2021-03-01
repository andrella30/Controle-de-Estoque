/**
 * 
 */
function validar() {
	let nome = frmProduto.nome.value
	let preco = frmProduto.preco.value
	let quantidade = frmProduto.quantidade.value
	let unidade = frmProduto.unidade.value
	if (nome === "") {
		alert('Preencha o campo Nome.')
		frmProduto.nome.focus()
		return false
	} else if (preco < 0 || preco === "" ) {
		alert('Preencha o campo Preco')
		frmProduto.preco.focus()
		return false
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade')
		frmProduto.quantidade.focus()
		return false
	} else if (unidade === "") {
		alert('Preencha o campo Unidade')
		frmProduto.unidade.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}