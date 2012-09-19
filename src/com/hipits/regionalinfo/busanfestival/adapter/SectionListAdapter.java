package com.hipits.regionalinfo.busanfestival.adapter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.hipits.regionalinfo.busanfestival.R;
import com.hipits.regionalinfo.busanfestival.model.Program;

/**
 * Adapter for sections.
 */
public class SectionListAdapter extends BaseAdapter implements ListAdapter,
        OnItemClickListener {
    private final DataSetObserver dataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            updateSessionCache();
        }

        @Override
        public void onInvalidated() {
            updateSessionCache();
        };
    };

    private final ListAdapter linkedAdapter;
    private final Map<Integer, String> sectionPositions = new LinkedHashMap<Integer, String>();
    private final Map<Integer, Integer> itemPositions = new LinkedHashMap<Integer, Integer>();
    private final Map<View, String> currentViewSections = new HashMap<View, String>();
    private int viewTypeCount;
    protected final LayoutInflater inflater;
    private String msg;

    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private View transparentSectionView;

    private OnItemClickListener linkedListener;

    public SectionListAdapter(final LayoutInflater inflater,
            final ListAdapter linkedAdapter, String msg) {
        this.linkedAdapter = linkedAdapter;
        this.inflater = inflater;
        this.msg = msg;
        linkedAdapter.registerDataSetObserver(dataSetObserver);
        updateSessionCache();
    }

    private boolean isTheSame(final String previousSection,
            final String newSection) {
        if (previousSection == null) {
            return newSection == null;
        } else {
            return previousSection.equals(newSection);
        }
    }

    private synchronized void updateSessionCache() {
        int currentPosition = 0;
        sectionPositions.clear();
        itemPositions.clear();
        viewTypeCount = linkedAdapter.getViewTypeCount() + 1;
        String currentSection = null;
        final int count = linkedAdapter.getCount();
        for (int i = 0; i < count; i++) {
            final Program item = (Program) linkedAdapter
                    .getItem(i);
            if (!isTheSame(currentSection, item.getSectionName())) {
                sectionPositions.put(currentPosition, item.getSectionName());
                currentSection = item.getSectionName();
                currentPosition++;
            }
            itemPositions.put(currentPosition, i);
            currentPosition++;
        }
    }

    
    public synchronized int getCount() {
        return sectionPositions.size() + itemPositions.size();
    }

   
    public synchronized Object getItem(final int position) {
        if (isSection(position)) {
            return sectionPositions.get(position);
        } else {
            final int linkedItemPosition = getLinkedPosition(position);
            return linkedAdapter.getItem(linkedItemPosition);
        }
    }

    public synchronized boolean isSection(final int position) {
        return sectionPositions.containsKey(position);
    }

    public synchronized String getSectionName(final int position) {
        if (isSection(position)) {
            return sectionPositions.get(position);
        } else {
            return null;
        }
    }

  
    public long getItemId(final int position) {
        if (isSection(position)) {
            return sectionPositions.get(position).hashCode();
        } else {
            return linkedAdapter.getItemId(getLinkedPosition(position));
        }
    }

    protected Integer getLinkedPosition(final int position) {
        return itemPositions.get(position);
    }

    
    public int getItemViewType(final int position) {
        if (isSection(position)) {
            return viewTypeCount - 1;
        }
        return linkedAdapter.getItemViewType(getLinkedPosition(position));
    }

    private View getSectionView(final View convertView, final String section) {
        View theView = convertView;
        if (theView == null) {
            theView = createNewSectionView();
        }
        setSectionText(section, theView);
        replaceSectionViewsInMaps(section, theView);
        return theView;
    }

    protected void setSectionText(final String section, final View sectionView) {
        final TextView textView = (TextView) sectionView
                .findViewById(R.id.listTextView);
        textView.setText(section);
    }

    protected synchronized void replaceSectionViewsInMaps(final String section,
            final View theView) {
        if (currentViewSections.containsKey(theView)) {
            currentViewSections.remove(theView);
        }
        currentViewSections.put(theView, section);
    }

    protected View createNewSectionView() {
    	View view = inflater.inflate(R.layout.section_view, null);
    	LinearLayout section = (LinearLayout)view.findViewById(R.id.section);

    	if (getMsg().equals("port")) {
    		section.setBackgroundColor(view.getResources().getColor(R.color.port));
		} else if (getMsg().equals("sea")) {
			section.setBackgroundColor(view.getResources().getColor(R.color.sea));
		} else if (getMsg().equals("rock")) {
			section.setBackgroundColor(view.getResources().getColor(R.color.rock));
		} else if (getMsg().equals("flame")) {
			section.setBackgroundColor(view.getResources().getColor(R.color.flame));
		} else if (getMsg().equals("sun")) {
			section.setBackgroundColor(view.getResources().getColor(R.color.sun));
		}
        return view;
    }
    
    public void setSectionColor(String msg) {
    	
    }

   
    public View getView(final int position, final View convertView,
            final ViewGroup parent) {
        if (isSection(position)) {
            return getSectionView(convertView, sectionPositions.get(position));
        }
        return linkedAdapter.getView(getLinkedPosition(position), convertView,
                parent);
    }

    @Override
    public int getViewTypeCount() {
        return viewTypeCount;
    }

    @Override
    public boolean hasStableIds() {
        return linkedAdapter.hasStableIds();
    }

    @Override
    public boolean isEmpty() {
        return linkedAdapter.isEmpty();
    }

    @Override
    public void registerDataSetObserver(final DataSetObserver observer) {
        linkedAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(final DataSetObserver observer) {
        linkedAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return linkedAdapter.areAllItemsEnabled();
    }

    @Override
    public boolean isEnabled(final int position) {
        if (isSection(position)) {
            return true;
        }
        return linkedAdapter.isEnabled(getLinkedPosition(position));
    }

    public void makeSectionInvisibleIfFirstInList(final int firstVisibleItem) {
        final String section = getSectionName(firstVisibleItem);
        // only make invisible the first section with that name in case there
        // are more with the same name
        boolean alreadySetFirstSectionIvisible = false;
        for (final Entry<View, String> itemView : currentViewSections
                .entrySet()) {
            if (itemView.getValue().equals(section)
                    && !alreadySetFirstSectionIvisible) {
                itemView.getKey().setVisibility(View.INVISIBLE);
                alreadySetFirstSectionIvisible = true;
            } else {
                itemView.getKey().setVisibility(View.VISIBLE);
            }
            
        }
        for (final Entry<Integer, String> entry : sectionPositions.entrySet()) {
            if (entry.getKey() > firstVisibleItem + 1) {
                break;
            }
            setSectionText(entry.getValue(), getTransparentSectionView());
        }
    }

    public synchronized View getTransparentSectionView() {
        if (transparentSectionView == null) {
            transparentSectionView = createNewSectionView();
        }
        return transparentSectionView;
    }

    protected void sectionClicked(final String section) {
        // do nothing
    }

    
    public void onItemClick(final AdapterView< ? > parent, final View view,
            final int position, final long id) {
        if (isSection(position)) {
            sectionClicked(getSectionName(position));
        } else if (linkedListener != null) {
            linkedListener.onItemClick(parent, view,
                    getLinkedPosition(position), id);
        }
    }

    public void setOnItemClickListener(final OnItemClickListener linkedListener) {
        this.linkedListener = linkedListener;
    }
}
