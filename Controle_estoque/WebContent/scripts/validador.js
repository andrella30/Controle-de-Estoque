/**
 * 
 */



function validar() {
	let nome = frmProduto.nome.value
	let preco = frmProduto.preco.value
	let quantidade = frmProduto.quantidade.value
	let unidade = frmProduto.unidade.value
	let valor = frmProduto.valor.value



	if (nome === "") {
		alert('Preencha o campo Nome.')
		frmProduto.nome.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preco')
		frmProduto.preco.focus()
		return false
	} else if (preco < 0) {
		alert('Valor Inválido')
		frmProduto.preco.focus()
		return false
	} else if (isNaN(quantidade)) {
		alert('Preencha o campo Quantidade')
		frmProduto.quantidade.focus()
		return false
	} else if (unidade === "") {
		alert('Preencha o campo Unidade')
		frmProduto.unidade.focus()
		return false
	} else if (valor === "" || valor < 0) {
		alert('Preencha o campo Valor corretamente')
		frmProduto.valor.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}