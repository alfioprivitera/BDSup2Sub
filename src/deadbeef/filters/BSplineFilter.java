package deadbeef.filters;

/*
 * Copyright 2009 Volker Oth (0xdeadbeef)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Bicubic spline filter.
 *
 * @author 0xdeadbeef
 */
public class BSplineFilter implements Filter {

	public float getRadius() {
		return 2.0f;
	}

	public float value(float value) {
		if (value < 0.0f) {
			value = - value;
		}
		if (value < 1.0f) {
			float tt = value * value;
			return 0.5f * tt * value - tt + (2.0f / 3.0f);
		}
		if (value < 2.0f) {
			value = 2.0f - value;
			return (1.0f / 6.0f) * value * value * value;
		}
		return 0.0f;
	}
}
