package com.hualongdata.hanlpext;

import com.hankcs.lucene.HanLPTokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.plugin.analysis.AnalysisHanLPPlugin;
import org.elasticsearch.test.ESTestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by yangbajing(yangbajing@gmail.com) on 2017-04-10.
 */
public class ESPluginTest extends ESTestCase {


    @Test
    public void hanlpTest() throws IOException{

        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), Settings.EMPTY, new AnalysisHanLPPlugin());
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("hanlp");
        HanLPTokenizer tokenizer = (HanLPTokenizer) tokenizerFactory.create();


    }


}