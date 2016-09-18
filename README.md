# BeautifulBezier

Some practice of Bezier curve , It's Beautiful

## About Bezier Curve

[维基百科-贝塞尔曲线](https://zh.wikipedia.org/wiki/%E8%B2%9D%E8%8C%B2%E6%9B%B2%E7%B7%9A)

| 阶数	|	效果		|	算法		|
|-------|-------|-------|
|	一阶贝塞尔（线段）	|	![](https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/B%C3%A9zier_1_big.gif/240px-B%C3%A9zier_1_big.gif)	|	B(t) = P0 + (P1 - P0) * t = (1 - t) * P0 + t * P1, t ∈ [0, 1]		|
|	二阶贝塞尔（抛物线）|	![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/B%C3%A9zier_2_big.gif/240px-B%C3%A9zier_2_big.gif)	|	B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]		|
|	三阶贝塞尔	|	![](https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/B%C3%A9zier_3_big.gif/240px-B%C3%A9zier_3_big.gif)	|	B(t) = (1 - t)^3 * P0 + 3P1 * t * (1 - t)^2 + 3P2 * t^2 * (1 - t) + P3 * t^3, t ∈ [0,1]		|

高阶贝塞尔曲线算法：

![](https://wikimedia.org/api/rest_v1/media/math/render/svg/c927f56552e184c4debebc83a08dc79896052a14)

> Site：[bezier-curve](http://myst729.github.io/bezier-curve/)

## Licence

    Copyright 2016 D_clock爱吃葱花
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.