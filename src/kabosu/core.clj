(ns kabosu.core
  (:import [com.worksap.nlp.sudachi DictionaryFactory Tokenizer$SplitMode]))

(defonce tokenizer (.create (.create (DictionaryFactory.))))

(defn tokenize
  [s]
  (map
   (fn [token] [(.surface token) (.partOfSpeech token)])
   (.tokenize tokenizer Tokenizer$SplitMode/C s)))
