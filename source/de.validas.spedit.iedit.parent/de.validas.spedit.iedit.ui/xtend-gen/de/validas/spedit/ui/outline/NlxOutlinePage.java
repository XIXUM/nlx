package de.validas.spedit.ui.outline;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.validas.spedit.ui.util.NlxDisplayRunHelper;
import de.validas.spedit.ui.util.ReflectionUtil;
import java.util.Collection;
import javax.annotation.Generated;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeContentProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NlxOutlinePage extends OutlinePage {
  private Thread thread;
  
  @Override
  protected void refreshViewer(final IOutlineNode rootNode, final Collection<IOutlineNode> nodesToBeExpanded, final Collection<IOutlineNode> selectedNodes) {
    Object _privateFromSuper = ReflectionUtil.getPrivateFromSuper(this, "labelProvider");
    final OutlineNodeLabelProvider labelProvider_super = ((OutlineNodeLabelProvider) _privateFromSuper);
    Object _privateFromSuper_1 = ReflectionUtil.getPrivateFromSuper(this, "contentProvider");
    final OutlineNodeContentProvider contentProvider_super = ((OutlineNodeContentProvider) _privateFromSuper_1);
    Object _privateFromSuper_2 = ReflectionUtil.getPrivateFromSuper(this, "LOG");
    final Logger LOG_super = ((Logger) _privateFromSuper_2);
    NlxDisplayRunHelper.runAsyncInDisplayThread(new Thread("Tree Viewer") {
      @Override
      public void run() {
        try {
          TreeViewer treeViewer = NlxOutlinePage.this.getTreeViewer();
          boolean _isDisposed = treeViewer.getTree().isDisposed();
          boolean _not = (!_isDisposed);
          if (_not) {
            NlxOutlinePage.this.getTreeViewer().getTree().setRedraw(false);
            IBaseLabelProvider _labelProvider = treeViewer.getLabelProvider();
            boolean _notEquals = (!Objects.equal(_labelProvider, labelProvider_super));
            if (_notEquals) {
              if (((!Objects.equal(treeViewer.getInput(), null)) && (!Objects.equal(treeViewer.getContentProvider(), null)))) {
                treeViewer.setInput(null);
              }
              treeViewer.setLabelProvider(labelProvider_super);
            }
            IContentProvider _contentProvider = treeViewer.getContentProvider();
            boolean _notEquals_1 = (!Objects.equal(_contentProvider, contentProvider_super));
            if (_notEquals_1) {
              if (((!Objects.equal(treeViewer.getInput(), null)) && (!Objects.equal(treeViewer.getContentProvider(), null)))) {
                treeViewer.setInput(null);
              }
              treeViewer.setContentProvider(contentProvider_super);
            }
            treeViewer.setInput(rootNode);
            treeViewer.expandToLevel(1);
            treeViewer.setExpandedElements(Iterables.<IOutlineNode>toArray(nodesToBeExpanded, IOutlineNode.class));
            IOutlineNode[] _array = Iterables.<IOutlineNode>toArray(selectedNodes, 
              IOutlineNode.class);
            StructuredSelection _structuredSelection = new StructuredSelection(_array);
            treeViewer.setSelection(_structuredSelection);
            ISelectionProvider selectionProvider = NlxOutlinePage.this.getSourceViewer().getSelectionProvider();
            selectionProvider.setSelection(selectionProvider.getSelection());
            NlxOutlinePage.this.treeUpdated();
          }
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable t = (Throwable)_t;
            LOG_super.error("Error refreshing outline", t);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          boolean _isDisposed_1 = NlxOutlinePage.this.getTreeViewer().getTree().isDisposed();
          boolean _not_1 = (!_isDisposed_1);
          if (_not_1) {
            NlxOutlinePage.this.getTreeViewer().getTree().setRedraw(true);
          }
        }
      }
    });
  }
}
