package org.utils;
import org.apache.commons.io.FileUtils;
import org.utils.api.AbstractFileReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:打成jar包后，从外面读取文件
 */
public class SystemFileReader extends AbstractFileReader {
    @Override
    public InputStream readByPath(String path) throws IOException {
        File file = FileUtils.getFile(path);
        if (file == null || !file.isFile()) {
            return null;
        }
        return FileUtils.openInputStream(file);
    }

    @Override
    protected String buildPath(String originalPath) throws IOException {
        return "." +  originalPath;
    }
}
