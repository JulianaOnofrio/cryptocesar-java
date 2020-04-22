package challenge;

public class CriptografiaCesariana implements Criptografia {
    byte casas = 3;

    @Override
    public String criptografar(String texto) {
        return gerarTextoCriptografia(texto, true);
    }

    @Override
    public String descriptografar(String texto) {
        return gerarTextoCriptografia(texto, false);
    }

    public String gerarTextoCriptografia(String texto, boolean criptografar) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String textoProcessado = new String();
        int caracter;

        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                caracter = criptografar ? texto.charAt(i) + casas : texto.charAt(i) - casas;
                textoProcessado = textoProcessado.concat(String.valueOf((char) caracter));
            } else {
                textoProcessado = textoProcessado.concat(String.valueOf(texto.charAt(i)));
            }
        }

        return textoProcessado;
    }
}