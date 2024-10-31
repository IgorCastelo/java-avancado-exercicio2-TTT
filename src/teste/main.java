package teste;

import dominio.Usuario;
import servico.UsuarioService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

       // usuarioService.adicionarUsuario(usuario)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite useu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        Usuario usuario = new Usuario(nome,email);
        Usuario usuario2 = new Usuario(nome.toLowerCase(Locale.ROOT),email.toLowerCase());

        try {
           usuarioService.adicionarUsuario(usuario);
            usuarioService.adicionarUsuario(usuario2);
        }catch (IllegalArgumentException e ){
         e.printStackTrace();
        }
    System.out.println("digite um nome para buscar por expressão regular: ");
        String nomeBusca = scanner.nextLine();
        usuarioService.buscarPorNomeRegex(nomeBusca);
    System.out.println("digite um email para buscar: ");
        String emailBusca = scanner.nextLine();
        usuarioService.buscarPorEmail(emailBusca);

    }
}
