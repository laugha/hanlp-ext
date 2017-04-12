package org.elasticsearch.plugin.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPAnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class AnalysisHanLPPlugin extends Plugin implements AnalysisPlugin {
    static {
//        System.out.println(System.getProperties().get("java.class.path"));
        Properties p = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            p.load(loader.getResourceAsStream("hanlp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.list(System.out);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return Collections.singletonMap("hanlp", HanLPTokenizerFactory::new);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("hanlp", HanLPAnalyzerProvider::new);
    }

}