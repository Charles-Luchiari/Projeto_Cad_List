package Produto.controller;

import Produto.model.Produto;
import Produto.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int numero = 0;
    @Override
    public void procurarPorNumero(int numero) {
        var produto = buscarNaCollection(numero);

        if (produto != null) produto.visualizar();
        else {
            System.out.println("Produto não encontrado!");
        }
    }

    @Override
    public void listarTodos() {
        Comparator<Produto> comparator = Comparator.comparing(Produto::getValor);
        listaProdutos.sort(comparator.reversed());
        for(Produto produto : listaProdutos){
            produto.visualizar();
        };
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto Cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        var buscaProduto = buscarNaCollection(produto.getNumero());

        if(buscaProduto != null){
            listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
            System.out.println("O produto "+ produto.getNome()+" foi atualizado com sucesso!");
        } else {
            System.out.println("O produto "+ produto.getNome()+" não foi encontrado!");
        }
    }

    @Override
    public void deletar(int numero) {
        var produto = buscarNaCollection(numero);
        if(produto != null) {
            if(listaProdutos.remove(produto) == true){
                System.out.println("O produto "+ produto.getNome()+ " foi excluido com sucesso!");
            }
        } else {
            System.out.println("O produto "+ produto.getNome()+ " não foi encontrado!");
        }
    }
    public int gerarNumero() {
        return ++numero;
    }
    public Produto buscarNaCollection(int numero) {
        for( var produto : listaProdutos) {
            if (produto.getNumero() == numero) {
                return produto;
            }
        }
        return null;
    }
}
