/**
 * Created by pstene on 3/13/16.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class tagger {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("usage: java TaggerDemo modelFile fileToTag");
            return;
        }
        MaxentTagger tagger = new MaxentTagger(args[0]);
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader(args[1])));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for(TaggedWord tw : tSentence) {
                System.out.println(tw.word() + " --- " + tw.tag());
            }
            System.out.println(Sentence.listToString(tSentence, false));
        }
    }
}
