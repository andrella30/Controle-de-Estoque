/**
 * 
 */
function validar() {
	let preco = frmEdicao.preco.value
	let quantidade = frmEdicao.quantidade.value
	let unidade = frmEdicao.unidade.value
	if (preco < 0 || preco === "") {
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
		document.forms["frmEdicao"].submit()
	}
}