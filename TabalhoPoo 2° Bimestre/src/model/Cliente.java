
package model;

public class Cliente {
    private int numero;
    private String nome;
    private String sexo;
    private int cpf;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
    }
       public int getCpf(){
           return cpf;
       }
       public void setCpf(int cpf){
           this.cpf=cpf;
       }
}
