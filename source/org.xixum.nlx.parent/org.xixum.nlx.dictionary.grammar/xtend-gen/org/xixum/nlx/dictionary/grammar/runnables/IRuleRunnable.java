package org.xixum.nlx.dictionary.grammar.runnables;

import java.util.Map;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IRuleRunnable {
  void run();

  void start();

  Map<Integer, INode> getResult();
}
