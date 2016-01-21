package com.hhz.guava;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ListsDemo {

	static class Source {
		Source(String text) {
			this.text = text;
		}

		String text;
	}

	static class Target {
		Target(String text) {
			this.text = text;
		}

		String text;
	}

	// Lists.transform 转换出来的list set方法无效
	public static void main(String[] args) {
		List<Source> srcList = Lists.newArrayList();
		srcList.add(new Source("one"));
		List<Target> list = Lists.transform(srcList,
				new Function<Source, Target>() {
					@Override
					public Target apply(Source input) {
						return new Target(input.text + "-target");
					}
				});
		list.get(0).text = "EMPTY";
		System.out.println(list.get(0).text);
	}

}
