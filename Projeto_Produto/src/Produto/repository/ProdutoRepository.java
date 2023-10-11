package Produto.repository;

import Produto.model.Produto;

public interface ProdutoRepository {
    //CRUD Produto
    public void procurarPorNumero(int numero);
    public void listarTodos();
    public void cadastrar(Produto produto);

    public void atualizar(Produto produto);

    public void deletar(int numero);
}
