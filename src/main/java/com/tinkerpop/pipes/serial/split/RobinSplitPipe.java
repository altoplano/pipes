package com.tinkerpop.pipes.serial.split;

/**
 * @author: Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RobinSplitPipe<S> extends AbstractSplitPipe<S> {

    protected int currentSplit = 0;

    public RobinSplitPipe(final int numberOfSplits) {
        super(numberOfSplits);
    }

    public void fillNext(int splitNumber) {
        final int splitSize = this.splits.size();
        for (int i = 0; i < splitSize; i++) {
            if (this.hasNext()) {
                this.splits.get(this.currentSplit).add(this.next());
                this.currentSplit = ++this.currentSplit % splitSize;
            } else {
                break;
            }
        }
    }
}
