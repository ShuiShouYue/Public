package org.utils.readJson.notnull;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:读取resource文件夹下的文件
 */
public class ResourceFileReader extends AbstractFileReader {
    @Override
    public InputStream readByPath(String path) {
        return ResourceFileReader.class.getResourceAsStream(path);
    }

    @Override
    protected String buildPath(String originalPath) throws IOException {
        return originalPath;
    }

}