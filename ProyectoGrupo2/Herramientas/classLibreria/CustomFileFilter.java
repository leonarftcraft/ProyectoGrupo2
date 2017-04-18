package classLibreria;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class CustomFileFilter extends FileFilter{
    String descricao;
    String extensoes[];

    public CustomFileFilter(String descricao, String[] extensoes){
        super();
        if (descricao == null) {
            this.descricao = extensoes[0];
        } else {
            this.descricao = descricao;
        }
        this.extensoes = (String[]) extensoes.clone();
        toLower(this.extensoes);
    }

    private void toLower(String array[]) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = array[i].toLowerCase();
        }
    }

    @Override
    public boolean accept(File arquivo) {
        if (arquivo.isDirectory()) {
            return true;
        } else {
            String path = arquivo.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensoes.length; i < n; i++) {
                String extension = extensoes[i];
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return descricao;
    }

	
	
}