package com.java.cadastro_usuario.infrastructure.entitys;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "usuarios")
@Entity

public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private  Integer id;

     @Email(message = "Email inválido")
     @NotBlank(message = "Email e obrigatório")
     @Column(name = "email" , unique = true)
     private  String email;

     @NotBlank(message = "O nome e obrigatorio")
     @Column(name = "nome" , length = 30)
     private String nome;

//     @Pattern(regexp = "\\d{10,11}" , message = "Telefone de ter 10 ou 11 digitos")
     @Size(max = 11)
     @Column(name = "telefone")
     private String telefone;

     @NotBlank(message = "Senha obrigatorio")
     @Column(name = "senha" )
     private String senha;




}
