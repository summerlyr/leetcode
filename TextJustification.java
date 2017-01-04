import java.util.LinkedList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		int m = words.length;
		List<String> result = new LinkedList<String>();
		int count = 0;
		while (count < m) {
			int start = count;
			int curlen = 0;
			int curcount = 0;
			while (curlen + curcount - 1 < maxWidth && count < m)//
			{
				curlen += words[count++].length();
				curcount++;
			}
			if (curlen + curcount - 1 > maxWidth) {
				curcount--;
				if (count != m) {
					curlen -= words[count--].length();
				}

			} else {
				count++;
			}

			int blank = (maxWidth - curlen) / curcount;
			int remain = (maxWidth - curlen) % curcount;
			int len = curcount;
			System.out.println(blank);
			System.out.println(remain);

			String curstr = "";

			for (int i = 0; i < curcount; i++) {

				curstr += words[start++];
				if (len-- > 0) {
					for (int j = 0; j < blank; j++) {
						curstr += " ";
					}
					if (remain-- > 0) {
						curstr += " ";
					}
				}

			}
			result.add(curstr);
		}
		return result;
	}

	public List<String> fullJustify2(String[] words, int maxWidth) {
		int m = words.length;
		List<String> result = new LinkedList<String>();
		int start = 0;
		int count = 0;
		int curlen = 0;
		int blank = 0;
		int remain = 0;
		for (int i = 0; i < m; i++) {
			if (curlen + words[i].length() + count <= maxWidth) {
				curlen += words[i].length();
				count++;
			} else if (curlen + words[i].length() + count >= maxWidth) {
				StringBuffer curstr = new StringBuffer();
				if (count == 1) {
					blank = maxWidth - curlen;
				} else {
					blank = (maxWidth - curlen) / (count - 1);
					remain = (maxWidth - curlen) % (count - 1);
				}

				for (int j = 0; j < count - 1; j++) {
					curstr.append(words[start++]);
					for (int b = 0; b < blank; b++) {
						curstr.append(" ");
					}
					if (remain-- > 0) {
						curstr.append(" ");
					}
				}
				curstr.append(words[start++]);
				if (count == 1) {
					for (int b = 0; b < blank; b++) {
						curstr.append(" ");
					}
				}
				// start = i;
				i = start - 1;
				blank = 0;
				remain = 0;
				count = 0;
				curlen = 0;
				result.add(curstr.toString());
			}
		}
		String last = "";
		for (int i = 0; i < count; i++) {
			if (i != count - 1) {
				last += words[start++] + " ";
			} else {
				last += words[start++];
			}

		}
		blank = maxWidth - last.length();
		for (int i = 0; i < blank; i++) {
			last += " ";
		}
		result.add(last);
		return result;
	}

    public List<String> fullJustify3(String[] words, int maxWidth) {
        int start = 0;
        int end = 0;
        List<String> res = new LinkedList<String>();
        if(words==null||words.length==0) return res;
        int len = 0;
        int lenspace = 0;
        for(int i=0;i<words.length;i++) {
            len += words[i].length();
            lenspace += words[i].length();
            int count = 0;
            if(lenspace>=maxWidth||lenspace+1==maxWidth) {
                if(lenspace>maxWidth) {
                	len-=words[i].length();
                	lenspace-=words[i].length();
                    end--;
                    i--; 
                }
                count = end-start+1;
                System.out.println(count);
                if(count==1||end==words.length-1) {
                    int space = maxWidth-len;
                    StringBuilder sb = new StringBuilder();
                    for(int j=start;j<=end;j++) {
                    	sb.append(words[start]+" ");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    for(int j=0;j<space;j++) {
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                } else if(count>1) {
                    int space = (maxWidth-len)/(count-1);
                    int remain = (maxWidth-len)%(count-1);
                    String spaces = "";
                    for(int j=0;j<space;j++) {
                        spaces += " ";
                    }
                    StringBuilder sb = new StringBuilder();
                    for(int j=start;j<end;j++) {
                        sb.append(words[j]);
                        sb.append(spaces);
                        if(remain-->0) sb.append(" ");
                    }
                    sb.append(words[end]);
                    res.add(sb.toString());
                }
                
                start = i+1;
                end = i+1;
                len = 0;
                lenspace = 0;
            } else {
                lenspace++;
                end = i+1;
            }
        }
        return res;
    }
    
    
    public List<String> fullJustify4(String[] words, int L) {
        List<String> lines = new LinkedList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }


        return lines;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification tj = new TextJustification();
		String[] words = { "This", "is", "an", "example", "of", "text", "justification.", };
		System.out.println(tj.fullJustify3(words, 16));

	}

}
