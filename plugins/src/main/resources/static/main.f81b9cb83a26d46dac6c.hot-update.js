/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
self["webpackHotUpdate_adria_plugins"]("main",{

/***/ "./src/app.js":
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__)\n/* harmony export */ });\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ \"./node_modules/react/index.js\");\n/* harmony import */ var _loadable_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @loadable/component */ \"./node_modules/@loadable/component/dist/loadable.esm.js\");\n/* harmony import */ var react_error_boundary__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! react-error-boundary */ \"./node_modules/react-error-boundary/dist/react-error-boundary.umd.js\");\n/* harmony import */ var react_error_boundary__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(react_error_boundary__WEBPACK_IMPORTED_MODULE_3__);\n/* harmony import */ var _shared_ErrorFallback__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./shared/ErrorFallback */ \"./src/shared/ErrorFallback.js\");\n\n\n\n\nvar UserPlugin = (0,_loadable_component__WEBPACK_IMPORTED_MODULE_1__.default)(function () {\n  return __webpack_require__.e(/*! import() */ \"src_plugins_users_index_js\").then(__webpack_require__.bind(__webpack_require__, /*! ./plugins/users/index */ \"./src/plugins/users/index.js\"));\n});\nvar DashboardPlugin = (0,_loadable_component__WEBPACK_IMPORTED_MODULE_1__.default)(function () {\n  return __webpack_require__.e(/*! import() */ \"src_plugins_dashboard_index_js\").then(__webpack_require__.bind(__webpack_require__, /*! ./plugins/dashboard/index */ \"./src/plugins/dashboard/index.js\"));\n});\n\nfunction App(_ref) {\n  var pluginID = _ref.pluginID;\n\n  var renderPlugin = function renderPlugin() {\n    switch (pluginID) {\n      case \"users\":\n        return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(UserPlugin, null);\n\n      case \"dashboard\":\n        return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(DashboardPlugin, null);\n    }\n  };\n\n  return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(react_error_boundary__WEBPACK_IMPORTED_MODULE_3__.ErrorBoundary, {\n    FallbackComponent: _shared_ErrorFallback__WEBPACK_IMPORTED_MODULE_2__.ErrorFallback\n  }, /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(react__WEBPACK_IMPORTED_MODULE_0__.Suspense, {\n    fallback: /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(\"div\", null, \"Loading...\")\n  }, renderPlugin()));\n}\n\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (App);\n\n//# sourceURL=webpack://@adria/plugins/./src/app.js?");

/***/ })

},
/******/ function(__webpack_require__) { // webpackRuntimeModules
/******/ "use strict";
/******/ 
/******/ /* webpack/runtime/getFullHash */
/******/ (() => {
/******/ 	__webpack_require__.h = () => ("ac188df9cb1431731d60")
/******/ })();
/******/ 
/******/ }
);