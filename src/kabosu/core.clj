(ns kabosu.core
  (:import [com.worksap.nlp.sudachi DictionaryFactory Tokenizer$SplitMode]))

(defonce tokenizer (.create (.create (DictionaryFactory.))))

(defn tokenize
  [s & {:keys [mode] :or {mode "C"}}]
  (map
   (fn [token] [(.surface token) (.partOfSpeech token)])
   (.tokenize tokenizer (condp =  mode
                              "A" Tokenizer$SplitMode/A
                              "B" Tokenizer$SplitMode/B
                              Tokenizer$SplitMode/C)  s)))
