package org.elasticsearch.plugin.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPAnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class AnalysisHanLPPlugin extends Plugin implements AnalysisPlugin {

    public static String PLUGIN_NAME = "analysis-hanlp";

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return Collections.singletonMap("hanlp", HanLPTokenizerFactory::new);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("hanlp", HanLPAnalyzerProvider::new);
    }

}