// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
package fitnesse.wikitext.widgets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteWidget extends ParentWidget {
  public static final String REGEXP = "^!note [^\r\n]*";
  private static final Pattern pattern = Pattern.compile("^!note (.*)");

  public NoteWidget(ParentWidget parent, String text) throws Exception {
    super(parent);
    Matcher match = pattern.matcher(text);
    if (match.find())
      addChildWidgets(match.group(1));
  }

  public String render() throws Exception {
    StringBuffer html = new StringBuffer("<span class=\"note\">");
    html.append(childHtml()).append("</span>");
    return html.toString();
  }
}
