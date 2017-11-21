/*
 * Copyright (c) 2017年11月20日18时26分01秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.json;
public class JsonDecode implements JsonData {
	private JsonDecode parent = null;
	private String json;
	public JsonDecode(String json) {
		this.json = json;
	}
	private JsonDecode(JsonDecode parent, String json) {
		this.parent = parent;
		this.json = json;
	}
	class Scope{
		int start;
		int end;
	}
	private boolean limitScope(Scope scope,char startChar,char endChar){
		if (json == null) {
			return false;
		}
		int start, end;
		for (start = 0; start < json.length(); start++) {
			if (json.charAt(start) == startChar) {
				break;
			}
		}
		if (start == json.length()) {
			return false;
		}
		for (end = json.length() - 1; end > start; end--) {
			if (json.charAt(end) == endChar) {
				break;
			}
		}
		if (start == end) {
			return false;
		}
		scope.start=start;
		scope.end=end;
		return true;
	}
	@Override
	public JsonData A(int index) {
		try {
			int start, end;
			Scope scope = new Scope();
			if (!limitScope(scope,'[',']')) {
				return this;
			}
			start=scope.start;
			end=scope.end;
			StringBuilder stringBuilder = new StringBuilder();
			int arrayIndex = 0;
			int objectLevel = 0;
			int arrayLevel = 0;
			boolean skip=false;
			boolean isString = false;
			while (++start < end) {
				char c = json.charAt(start);
				if (!skip&&c == '\"') {
					isString = !isString;
				}
				if (skip) {
					skip=false;
				}else if (c=='\\'){
					skip=true;
				}
				if (!isString) {
					if (arrayLevel == 0) {
						if (c == '{') {
							objectLevel++;
						}
						if (c == '}') {
							objectLevel--;
						}
					}
					if (objectLevel == 0) {
						if (c == '[') {
							arrayLevel++;
						}
						if (c == ']') {
							arrayLevel--;
						}
					}
				}
				if (!isString&&c == ',' && objectLevel == 0 && arrayLevel == 0) {
					arrayIndex++;
					continue;
				}
				if (arrayIndex == index) {
					stringBuilder.append(c);
				} else if (arrayIndex > index) {
					break;
				}
			}
			return new JsonDecode(this, stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
	}
	
	@Override
	public JsonData O(String key) {
		try {
			int start, end;
			Scope scope = new Scope();
			if (!limitScope(scope,'{','}')) {
				return this;
			}
			start=scope.start;
			end=scope.end;
			StringBuilder stringBuilder = new StringBuilder();
			int arrayIndex = 0;
			int objectLevel = 0;
			int arrayLevel = 0;
			boolean isString = false;
			while (++start < end) {
				char c = json.charAt(start);
				if (c == '\"') {
					isString = !isString;
				}
				if (!isString) {
					if (arrayLevel == 0) {
						if (c == '{') {
							objectLevel++;
						}
						if (c == '}') {
							objectLevel--;
						}
					}
					if (objectLevel == 0) {
						if (c == '[') {
							arrayLevel++;
						}
						if (c == ']') {
							arrayLevel--;
						}
					}
				}
				if (c == ',' && objectLevel == 0 && arrayLevel == 0) {
					arrayIndex++;
					continue;
				}
				//if (arrayIndex == index) {
				//	stringBuilder.append(c);
				//} else if (arrayIndex > index) {
				//	break;
				//}
			}
			return new JsonDecode(this, stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
	}
	@Override
	public JsonData P() {
		if (parent == null) {
			return this;
		}
		return parent;
	}
	@Override
	public JsonData H() {
		if (parent == null) {
			return this;
		}
		return parent.H();
	}
	@Override
	public int i() {
		try {
			return Integer.parseInt(json.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public String s() {
		return json;
	}
}
