
FutureJS wall
=============

A small clojurescript canvas project for the workshop "diving into
clojurescript" of FutureJS

```
lein cljsbuild auto
```

Open lighttable and a browser tab, and connect to it to eval and play with the
code.

The different versions of the code are stored in `src-steps/`.


Steps
-----

### 1. Initial project

Look for project.clj. Compilation setup and dependencies.

**Web ouput is in `web/`**

`web/index.html` and a `web/style.css`

**Source is in src**
`src/futurejs_wall/core.cljs`

**For live development:**

* In a terminal: `lein cljsbuild auto`
* In Lighttable:
  * ctrl-space -> Add browser tab
  * Put the full url of your index.html as in Chrome
    `file:///Users/jkn/dev/projects/diving-into-clojurescript/code/exercises/futurejs-wall/web/index.html`
  * Go to `core.cljs`
  * cmd-enter on the `println`
  * When LT asks, choose the file url
  * Connected to a browser!!
  * Open the console (View -> Console) and see the println do its thing (shares browser tab console with LT console)


### 2. Namespace (module) and accessing JS stuff

Look at the top form on core.cljs

```
(ns futurejs-wall.core
  (:require [monet.canvas :as canvas]))
```

That means that we are in the module `core` of the module `futurejs-wall`, and the instruction below means we are importing the module `canvas` of the library `monet` aliased as `canvas`.

Using autocomplete and showing the docs we can explore the lib:

```
(canvas/init
;; init
;; monet.canvas
;; ([canvas & [context-type]])
```

We will use it later.

Lets mess around with the browser.

To access things from JS, we use the namespace/module `js/...`. Since in js there is only a global, from there we can get everything.

Try and eval this:

```
(js/alert "Hi!")
```

To call a method, we do `(.method object arg1 arg2)`:

```
(.write js/document "Hi!")
```

```
(def body (.querySelector js/document "body"))
```

To get properties `body.innerHTML` we use `.-innerHTML` instead:

```
(.-innerHTML body)
```

To set properties, we use the function `set!`:

```
(set! (.-innerHTML body) "Shut up.")
```

Cool, we know now.


### 3. Initialize our canvas.

We will use monet to manage the canvas. [Usage](https://github.com/rm-hull/monet) and [API](http://www.destructuring-bind.org/monet/)

* Get the dom element
* Initialize canvas/init and save the returning monet-canvas
* We can add entities to the canvas (auto drawed and auto updated).
* Add a background entity, as in the example usage

*Code is in `src-steps/1`*

### 4. Make the canvas fullscreen

* Get the window height and width.
* Set the dom canvas width and height.
* Change our background to be fullscreen.

*Code is in `src-steps/2`*

### 5. Organisation

* Move background related logic to its own namespace
* Define a create (for the value)
* Define a update (for the update fn)
* Define a render! (for the render fn)
* Move the color to the value instead of hardcoded in the render
* Change `core.cljs` to comply

*Code is in `src-steps/3`*

### 6. Add some text

We are going to add a big title.

* Create a new `text` namespace
* Follow the same as in background. Text will have `x` `y` and `text` values.
* Use the
* In `core.cljs` add at the end a section to add a new entity

*Code is in `src-steps/4`*

### 7.
