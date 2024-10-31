package servico;

import dominio.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UsuarioService {

    List<Usuario> usuariosLista = new ArrayList<>();

    @Override
    public String toString() {
        return "UsuarioService{" +
                "usuariosLista=" + usuariosLista +
                '}';
    }


    public void adicionarUsuario(Usuario usuario) throws IllegalArgumentException {
        class ValidadorEmail {
            public boolean validar(String email) {
                return usuario.getEmail() != null && usuario.getEmail().contains("@");
            }
        }
        ValidadorEmail validadorEmail = new ValidadorEmail();

        if (usuario == null || !validadorEmail.validar(usuario.getEmail()) ||
                usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Dados do usuário são inválidos.");
        }

            usuariosLista.add(usuario);
        System.out.println("Adicionando usuario: "+ usuario.getNome());
        }

        public Optional<Usuario> buscarPorEmail(String email) {
        for (Usuario u : usuariosLista) {
            if (email.equals(u.getEmail())) {
                System.out.println("Buscando por Email: "+Optional.of(u));
            }
        }
        return Optional.empty();
    }


    public Optional<Usuario> buscarPorNomeRegex(String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<String> resultado = new ArrayList<>();

        for (Usuario usuario : usuariosLista) {
            if (pattern.matcher(usuario.getNome()).matches()) {
                System.out.println("Buscando por Expressões regulares: " + usuario.toString());
            }

        }
        return Optional.empty();
    }
}





