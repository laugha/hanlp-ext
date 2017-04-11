package org.elasticsearch.index.analysis;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment;
import com.hankcs.lucene.HanLPTokenizer;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class HanLPTokenizerFactory extends AbstractTokenizerFactory {

    private boolean enablePorterStemming;

    public HanLPTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        this.enablePorterStemming = settings.getAsBoolean("enablePorterStemming", false);
    }

    @Override
    public Tokenizer create() {
        return new HanLPTokenizer(HanLP.newSegment(), null, enablePorterStemming);

    }

}
